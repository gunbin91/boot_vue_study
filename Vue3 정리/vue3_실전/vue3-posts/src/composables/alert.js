import { ref } from "vue";

export function useAlert() {
  const alertParams = ref([]);

  const vAlert = (message, error) => {
    alertParams.value.push({
        message: message,
        type: error == true? 'alert-success':'alert-danger'
    })
    setTimeout(()=>{
        alertParams.value.shift();
    }, 2000)
  }

  return{
    alertParams,
    vAlert,
  }

}