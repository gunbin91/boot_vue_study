import { useAlertStore } from "@/store/alert";

export function useAlert() {
  const alertStore = useAlertStore();
  const {alerts:alertParams, vAlert} = alertStore;

  return{
    alertParams,
    vAlert,
  }

}