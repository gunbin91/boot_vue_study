import axios from "axios";
import { isReactive, isRef, ref, unref, watchEffect } from "vue";

axios.defaults.baseURL = 'http://127.0.0.1:5000'

const defaultOptions = {
  imediate: true,
}

export const useAxios = (url, config = {}, options = {}) => {
  const response = ref(null);
  const data = ref([]);
  const err = ref(null);
  const loading = ref(false);

  const { params } = config;

  const { onSuccess, onError, imediate } = {
    ...defaultOptions,
    ...options,
  };

  const execute = (body)=>{
    loading.value = true;
    axios(unref(url), {
      ...config, 
      params: unref(params),
      data: typeof body === 'object'? body: {},
    })
    .then(res => {
      response.value = res;
      data.value = res.data;
      if(onSuccess){
        onSuccess(res);
      }
    })
    .catch(error => {
      err.value = error;
      if(onError){
        onError(error);
      }
    })
    .finally(()=>{
      loading.value = false;
    })
  };

  if(isRef(params) || isReactive(params) || isRef(url)){
    console.log("반응형");
    watchEffect(()=>{
      execute();
    });
  }else{
    if(imediate){
      execute();
    }
  }

  return {data, err, loading, response, execute}
}