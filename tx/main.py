import locust
import debugtalk


class MyUser(locust.HttpUser):
    wait_time = locust.between(1, 2)

    @locust.task
    def test_test(self):
        api_url = "/test"
        params = {"a": debugtalk.get_random(), "b": debugtalk.get_random_str()}
        resp = self.client.get(api_url, params=params)
        assert resp.status_code == 200
