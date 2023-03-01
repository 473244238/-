import VueRouter from "vue-router"
import Welcome from "../components/WelcomePanel"
import Login from "../components/LoginPanel"
import Register from "../components/RegisterPanel"
import Home from "../components/HomePage"
import Center from "../components/OperationZone"
import Uploadeface from '../components/UploadeForm'
import FundList from '../components/FundListDisplay'
import fundData from "../components/fundData"
//创建路由器
export default new VueRouter({
    routes: [{
        path: '/',
        component: Welcome
    },
    //interface 1
    {
        path: '/login',
        component: Login
    },
    //interface 2
    {
        path: '/register',
        component: Register
    },
    //interface 3
    {
        path: '/home/:id',
        component: Home,
        name: "home",
        children: [{
            path: 'center',
            name: 'center',
            component: Center
        },
        {
            path: "fundlist",
            name: "fundlist",
            component: FundList
        }
        ],

    },
    //interface 4
    {
        path: "/upload/:id",
        name: "form",
        component: Uploadeface,

    },
    {
        path: "/fund",
        name: "fundData",
        component: fundData,
    }
    ]
})