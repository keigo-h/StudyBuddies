import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import 'firebase/compat/firestore';

/* This is the configuration for the firebase app. */
const firebaseConfig = {
    apiKey: "AIzaSyCAaO0Exalg5re_uVpT7IBjjX5lo6c372g",
    authDomain: "cs32-authentication.firebaseapp.com",
    projectId: "cs32-authentication",
    storageBucket: "cs32-authentication.appspot.com",
    messagingSenderId: "29477990769",
    appId: "1:29477990769:web:67b75c9636e62307ee06d0"
  };

// Initialize Firebase
const fire = firebase.initializeApp(firebaseConfig);

export default fire;