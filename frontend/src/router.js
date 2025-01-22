
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import TaskTaskManager from "./components/listers/TaskTaskCards"
import TaskTaskDetail from "./components/listers/TaskTaskDetail"
import TaskNotificationManager from "./components/listers/TaskNotificationCards"
import TaskNotificationDetail from "./components/listers/TaskNotificationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/tasks/tasks',
                name: 'TaskTaskManager',
                component: TaskTaskManager
            },
            {
                path: '/tasks/tasks/:id',
                name: 'TaskTaskDetail',
                component: TaskTaskDetail
            },
            {
                path: '/tasks/notifications',
                name: 'TaskNotificationManager',
                component: TaskNotificationManager
            },
            {
                path: '/tasks/notifications/:id',
                name: 'TaskNotificationDetail',
                component: TaskNotificationDetail
            },



    ]
})
