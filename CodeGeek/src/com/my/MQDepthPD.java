import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.ibm.mq.MQException;
import com.ibm.mq.constants.CMQC;
import com.ibm.mq.constants.CMQCFC;
import com.ibm.mq.pcf.PCFMessage;
import com.ibm.mq.pcf.PCFMessageAgent;

/**
 * 
 * @author Prakash Dayaramani
 *
 */
public class MQDepthPD {
	// -h 10.167.168.48 -p 1414 -c TESTER.CLIENT.01 -s 5000 -i 3
	String host;
	int port;
	String channel;
	HashMap<String, Integer> maxDepthMap = new HashMap<String, Integer>();

	public MQDepthPD(String host, int port, String channel) throws MQException {
		this.host = host;
		this.port = port;
		this.channel = channel;
	}

	public String getMQStatistics() throws Exception {

		SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss.SSS");
		String timeString = formatterTime.format(new Date());
		String statistics = "";
		PCFMessageAgent pcfAgent = new PCFMessageAgent(host, port, channel);

		// Prepare PCF command to inquire queue status (status type)
		PCFMessage inquireQueueStatus = new PCFMessage(CMQCFC.MQCMD_INQUIRE_Q_STATUS);
		inquireQueueStatus.addParameter(CMQC.MQCA_Q_NAME, "*");
		inquireQueueStatus.addParameter(CMQCFC.MQIACF_Q_STATUS_TYPE, CMQCFC.MQIACF_Q_STATUS);
		inquireQueueStatus.addParameter(CMQCFC.MQIACF_Q_STATUS_ATTRS, new int[] { CMQC.MQCA_Q_NAME, CMQC.MQIA_CURRENT_Q_DEPTH,
				CMQCFC.MQIACF_OLDEST_MSG_AGE, CMQC.MQIA_OPEN_INPUT_COUNT, CMQC.MQIA_OPEN_OUTPUT_COUNT, CMQCFC.MQIACF_UNCOMMITTED_MSGS });

		PCFMessage messages[] = pcfAgent.send(inquireQueueStatus);

		//time,queuename,depth,oldest_msg_age,open_input_count,open_output_count,uncommited_messages
		for (PCFMessage message : messages) {

			String queueName = message.getStringParameterValue(CMQC.MQCA_Q_NAME);
			Integer queueDepth = message.getIntParameterValue(CMQC.MQIA_CURRENT_Q_DEPTH);
			if (!(queueName.matches("SYSTEM.*") || queueName.matches("AMQ.*") ||queueName.equalsIgnoreCase("ERROR_LOG") || (queueDepth == 0))) {
				queueName = queueName.replaceAll("\\s+", "");
				int messageAge = message.getIntParameterValue(CMQCFC.MQIACF_OLDEST_MSG_AGE);
				int currentInputCount = message.getIntParameterValue(CMQC.MQIA_OPEN_INPUT_COUNT);
				int currentOutputCount = message.getIntParameterValue(CMQC.MQIA_OPEN_OUTPUT_COUNT);
				int uncommitedMessages = message.getIntParameterValue(CMQCFC.MQIACF_UNCOMMITTED_MSGS);

				statistics = statistics + timeString + "," + queueName + "," + queueDepth + "," + messageAge + "," + currentInputCount + ","
						+ currentOutputCount + "," + uncommitedMessages + "\n";
			}
		}
		return statistics;
	}

	public static void main(String[] args) throws Exception {

		
		while(true) {
			// MQDepthPD mq = new MQDepthPD("10.167.168.48", 1414,
			// "TESTER.CLIENT.01");
			MQDepthPD mq = new MQDepthPD("10.167.168.48", 1414, "SUPPORT.EXPLORER.01");

			try {
				System.out.print(mq.getMQStatistics());
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Error:" + e.getLocalizedMessage());
				Thread.sleep(5000);
			}
		}

	}

	public int init() {
		this.channel = "10.167.168.48";
		this.port = 1414;
		this.channel = "TESTER.CLIENT.01";
		return 0;
	}

	public int action() {
		try {
			String st = getMQStatistics();
			System.out.println(st);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}