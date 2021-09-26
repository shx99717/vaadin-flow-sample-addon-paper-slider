// this js file will be finally included in an all-in-one bundle.js/main.js after webpack, therefore even the referencing
// component in this case the PaperSlider has not been initialized on the page, this javascript will
// still be triggered, in this sense, this is global included
console.log("The file my-module.js is loaded");
