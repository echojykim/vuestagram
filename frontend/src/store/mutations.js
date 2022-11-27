import {
    FETCH_BOARD_LIST,
    FETCH_BOARD
} from './mutation-types'

export default {
    [FETCH_BOARD_LIST] (state, boards) {
        state.Boards = boards 
    }, 
    [FETCH_BOARD] (state, board) {
         state.Board = board 
     }
}
