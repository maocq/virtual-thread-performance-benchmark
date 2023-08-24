import Config

config :perf_analyzer,
  url: "http://_IP_:8080/api/otherusercase/path",
  request: %{
    method: "GET",
    headers: [],
    body: ""
  },
  execution: %{
    steps: 3,
    increment: 10,
    duration: 200,
    constant_load: false,
    dataset: :none,
    separator: ","
  },
  distributed: :none

config :logger,
  level: :warn
