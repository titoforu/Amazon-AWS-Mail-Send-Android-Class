# Amazon AWS Mail Send from Android

This class required the AWS Library from Amazon and you have to setup a IAM user in AWS with permission to SES. You only have to provide key and secret of the IAM. Just add to your android app code. Please call it from a background thread. The dependencies of the class are given below.
compile 'com.amazonaws:aws-android-sdk-core:2.2.13'
compile 'com.amazonaws:aws-android-sdk-cognito:2.2.13'
compile 'com.amazonaws:aws-android-sdk-ses:2.4.5'
compile 'com.amazonaws:aws-android-sdk-ddb:2.2.13'

Enjoy SES with Android. 
