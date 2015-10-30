# StreetHawk's Beacon Plugin

## Introduction
The repository hosts Phonegap plugin of StreetHawk SDK's Beacon module. The plugin is required if you wish to run campaigns based on your application user entering or exiting a Beacon region.

## Integration Steps
Add Beacon plugin by running the below command.
```
$ cd <APPLICATION_DIRECTORY>
$ cordova plugin add streethawkbeacon
```
Note that beacon plugin requires StreetHawk Analytics plugin which can be added by running the below mentioned command

```
cordova plugin add streethawkanalytics  --variable APP_KEY=<YOUR_APPLICATIONS_APP_KEY> --variable URL_SCHEME=<URL_SCHEME_OF_APP>
```
Replace YOUR_APPLICATIONS_APP_KEY with app_key registered with StreetHawk for your application and URL_SCHEME_OF_APP with deeplinking scheme of your application.

## Documentation
Click [here](https://streethawk.freshdesk.com/solution/articles/5000680139) for detailed documentation of StreetHawk's Analytics plugin

## Other StreetHawk Plugins

* [Growth](https://github.com/StreetHawkSDK/PhonegapGrowth) for Viral and organic growth
* [Push](https://github.com/StreetHawkSDK/PhonegapPush) Push messaging in your application
* [Geofence](https://github.com/StreetHawkSDK/PhonegapGeofence) for running geofence based campaigns 
* [Location](https://github.com/StreetHawkSDK/PhonegapLocations) for running campaigns based on user's location
* [Feeds](https://github.com/StreetHawkSDK/PhonegapFeeds) for sending feeds in your application

[Streethawk](http://www.streethawk.com) 
