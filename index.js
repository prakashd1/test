var async = require("async");
var sendSSH = require("./sendSSH").sendSSH;
var sendssh = new sendSSH();


var asyncTasks = [];

var hosts = ["10.167.74.102","10.167.74.103","10.167.74.104","10.167.72.210","10.167.72.211"];
// Loop through some items
hosts.forEach(function(host){
  // We don't actually execute the async action here
  // We add a function containing it to an array of "tasks"
  asyncTasks.push(function(callback){
    // Call an async function, often a save() to DB

      sendssh.connect({
       server:        {
        host:         host,
        userName:     "p758283t",
        password:     "Password34",
       },
       commands:      ["date +%s"],
       connectedMessage:    "Connected to host" ,
       onCommandComplete:   function( command, response, sshObj) {
         //we are listing the dir so output it to the msg handler
        //  if (command === "ls -l"){
        //    this.emit("msg", response);
        //  }
        //console.log("command completed : " + command + ":" + response +":" + sshObj );
        var t=response.split(" ");
        var t2=t[1].split("\n");
        console.log(sshObj.server.host + " : " + t2[1] );
      },
      onmsg: function(msg){
        console.log("Message received : " + msg);
      }
      });
  });
});
// Now we have an array of functions doing async tasks
// Execute all async tasks in the asyncTasks array
async.parallel(asyncTasks, function(){
  // All tasks are done now
console.log("All tasks are done");
});
