var sendSSH = function() {};


sendSSH.prototype.connect = function (host) {
  var SSH2Shell = require ('ssh2shell'),
    //Create a new instance passing in the host object
    SSH = new SSH2Shell(host),
    //Use a callback function to process the full session text
    callback = function(sessionText){
    //  console.log(sessionText + ": "  + host);

    }

  //Start the process
  SSH.connect(callback);
};

exports.sendSSH = sendSSH;
