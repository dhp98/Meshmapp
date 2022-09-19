# Meshmapp
MeshNetwork Messaging and Map Navigating Android App. Useful during Natural Disasters.

# codefundo-2k18

>“There's no harm in hoping for the best as long as you're prepared for the worst.” – Stephen King_

One of the worst thing that could happen after a disaster is Internet and cellular networks being down.

When the most important thing is to communicate your plight to authorities, relief workers, and the outside world, reconnecting to a network to communicate can become as important as food or clean drinking water — especially because you might not be able to get the latter without the former.

### Our Plan:
A simple, easy & quick-to-use **_Android App_** that helps people who are stuck in natural disaster, in moving to a safer location using an offline map ,at the same time helping them to communicate with others,even when there is no Network coverage or Internet.

_Kind Note :-Our app prototype will be centered on people stuck in flood like situation_

### Main Functionalities and Use:
**real time FloodAlerts :** So that a user gets notified about any flood prediction in that area.

**Offline Map download:** Navigate to a safer location/hospital.

**Peer2Peer connection:** Authorities can locate people stuck in a disaster more easily in absense of internet.(*connecting devices must have this app installed to communciate*) 

**Gesture-Control**-for quick-to-use interface.for eg. one tap-send location via P2P conection.

### App Work-flow : 

1-Our app will give real-time FloodAlerts to the user ,using _floodAlerts API by shoothill_ ,through push notifications.

2-On receiving floodAlert - The App will automatically download a map ,(so that the map is available offline)route-to a safer location from the current location of the user ;with the users consent.

3-The app provides the funtionality of communicating with other users of the app ,in the absense of internet and network coverage, using _mesh-networks_ concept.

4-Gesture Control - provides a quick way to send info ,such as location ,of a user to the other people.  

### Technologies/Frameworks Used:

**Android Studio /Android SDK.**

**google maps api.**

**RightMesh-** open source framework for  implementing mesh network in app.

**Sensey** - open source lib. for android to implement gesture control in our app.

**Github** -version control.

**Azure**-for cloud deployment.

