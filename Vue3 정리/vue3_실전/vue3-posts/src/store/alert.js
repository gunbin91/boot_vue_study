import { defineStore } from "pinia";

export const useAlertStore = defineStore('alert', {
  state: ()=> ({
    alerts: [],
  }),
  actions: {
    vAlert (message, error) {
      this.alerts.push({
        message: message,
        type: error == true? 'alert-success':'alert-danger'
      })
      setTimeout(()=>{
        this.alerts.shift();
      }, 2000)
    }
  }
})