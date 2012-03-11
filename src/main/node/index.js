var redis = require("redis");

var redisPort = 6379;
var redisHost = '127.0.0.1';
var redisPassword = '';

var client = redis.createClient(redisPort, redisHost);
client.auth(redisPassword);

client.on("message", function (channel, message) {
    console.log("Got message: " + message);
});
client.subscribe("voted")