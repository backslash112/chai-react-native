/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */
'use strict';

var React = require('react-native');
var Intent = require('NativeModules').RNIntent;
var FBLogin = require('./fblogin');
       
var {
  AppRegistry,
  Image,
  StyleSheet,
  ListView,
  TouchableHighlight,
  Text,
  View,
} = React;

var REQUEST_URL = 'http://chai.media/public_api/random/';

var AwesomeProject = React.createClass({
  getInitialState: function() {
    return {
      dataSource: new ListView.DataSource({
        rowHasChanged: (row1, row2) => row1 !== row2,
      }),
      loaded: false,
    };
  },
  componentDidMount: function() { // called once
    this.fetchData();
  },
  fetchData: function() {
    fetch(REQUEST_URL)
      .then((response) => response.json())
      .then((responseData) => {
        this.setState({
          dataSource: this.state.dataSource.cloneWithRows(responseData.result),
          loaded: true,
        });
      })
      .done();
  },
  render: function() {

    return (<FBLogin width='100' style={styles.mybutton}/>);
    
    if (!this.state.loaded) {
      return this.renderLoadingView();
    }

    return (
      <ListView
        dataSource={this.state.dataSource}
        renderRow={this.renderNewsRow}
        style={styles.listView}
      />
    );
  },

  renderLoadingView: function() {
    return (
      <View style={styles.container}>
        <Text>
          Loading news...
        </Text>

      </View>
    );
  },

  renderNewsRow: function(news, sectionID: number, rowID: number) {
    return (
      <TouchableHighlight onPress={() => this._pressRow(news.video_id,rowID)}>
      <View style={styles.container}>
        <Image
          source={{uri: news.news_url}}
          style={styles.thumbnail}
        />
        <View style={styles.rightContainer}>
          <Text style={styles.title}>{news.news_title}</Text>
          <Text style={styles.year}>{news.news_date}</Text>
        </View>
      </View>
      </TouchableHighlight>
    );
  },

   _pressRow: function(video_id, rowID: number) {
      // console.log(news_url)
      Intent.intent_youtube({
        url: video_id,
      });
    },

});

var styles = StyleSheet.create({
  listView: {
    paddingTop: 20,
    backgroundColor: '#F5FCFF',
  },
  container: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  rightContainer: {
    flex: 1,
  },
  title: {
    fontSize: 20,
    marginBottom: 8,
    textAlign: 'center',
  },
  year: {
    textAlign: 'center',
  },
  thumbnail: {
    width: 53,
    height: 81,
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  mybutton: {
    width: 150,
    height: 50
  },
});

AppRegistry.registerComponent('ChaiMedia', () => AwesomeProject);
