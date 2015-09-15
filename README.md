setup
-----

follow
https://facebook.github.io/react-native/docs/getting-started.html#content
https://facebook.github.io/react-native/docs/android-setup.html#content

`npm install -g react-native-cli`
`npm install`
`react-native run-android`

if you get an error, in another window run
`adb reverse tcp:8081 tcp:8081`


What we have now

1. `index.android.js` 
	* loads stuff from http://chai.media/public_api/random/
	* renders it into a listview

