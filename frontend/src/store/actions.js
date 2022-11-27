import {
    FETCH_BOARD_LIST,
    FETCH_BOARD
} from './mutation-types'

import axios from 'axios'
//import router from '@/router'
//npm install axios --save-dev

export default {
   fetchBoardList ({ commit }) {
       return axios.get('http://localhost:7777/board/list') 
                       //엑시오스에 정보요청을 해서 스프링 컨트롤러로 가야함.
                       //spring이 리턴한 결과는 .then()안의 res로 값이 들어감 
               .then((res) => { 
                   commit(FETCH_BOARD_LIST, res.data)
               })
   },
   fetchBoard ({ commit }, boardNo) { //스프링이 return한 결과는 res로 들어감 
       return axios.get(`http://localhost:7777/board/${boardNo}`)
               .then((res) => {
                   commit(FETCH_BOARD, res.data)
               })
   }
}