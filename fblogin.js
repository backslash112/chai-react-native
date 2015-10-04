var { requireNativeComponent, PropTypes } = require('react-native');

var iface = {
  name: 'LoginButton',
  propTypes: {
    width: PropTypes.string
  }
};

var FBButton = requireNativeComponent('RCTFBLoginButton', iface);
module.exports = FBButton;
