![chai-media-logo](https://cloud.githubusercontent.com/assets/5732914/9900123/37762e6c-5c24-11e5-8446-35dbab4d4c64.png)
## Wolfram Alpha for News

Chai is an ambitious project with the aim to create a full-fledged news consumption app completely in Facebook's React Native for Android.

**Warning:** Chai is a work in progress; early-stage and experimental.

## Setup

Follow the "Getting Started" guide from [**Facebook's React Native GitHub**](https://facebook.github.io/react-native/docs/getting-started.html#content)

```
npm install -g react-native-cli
npm install
react-native run-android
```

If you get an error, in another window run
`adb reverse tcp:8081 tcp:8081`


## Completed

1. We have an initial view that
	* Loads json from http://chai.media/public_api/random/
	* Renders it into a listview

## TODOs

1. User Login and User Settings Syncing with Backend Server
   * We need to allow a user to log in with Facebook and create an account for them on our chai.media backend
   * We should be able to store user settings in a {key:value} with the backend and keep both of these in sync (updates can flow both ways)
   * On the app side, it should be in a way that anywhere in the rest of the app we can query for these user settings (example: get list of all favorite categories of logged in user) this should not need a network query to the backend
   * Settings screen for user to check and update settings
      > enable / disable push notifications
      > choose favorite categories etc.

2. Main View of App
   * Swipe toolbar with -> My News | Today's News | Trending
   * Each section should be a good looking infinite scrolling cardview
   * On click of an item we will open the items detail view; back should return to the user's position in the scroll
   * Items must be cachable (1hr); i.e. you can expect new content only after an hour
   * Pull to refresh to force refresh of the screen

3. Detail View
   * This one view should behave differently depending on the type of content that is being requested to be shown in detail
   * If it is an entity (eg: Trump / Google / India )
      > example: http://chai.media/channel/India/
   * If it is a news article 
      > example: http://chai.media/video/south-china-sea-dispute-china-builds-third-airstrip-at-mischief-reef-tomonews/
      * Video play button will throw an intent to open the YouTube video

## Bug Tracker

Found a bug? Report it [here](https://github.com/chaimedia/chai-android/issues/)!

## Feature Request

Have an idea? Add it [here](https://github.com/chaimedia/chai-android/issues/)!

## License

##### chai-android is released under the [MIT License](https://opensource.org/licenses/MIT).
The full license text is included in `LICENSE.txt`.
