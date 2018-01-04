class TestScript {
    static boolean output(def str){

        return Long.parseLong(str.responseTime) > 100 && str.status == "running"
    }
}