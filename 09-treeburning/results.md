Sheikh Alif

1. I chose a board size of 1000 because the difference of the least and greatest average runtimes in this board
were the greatest which highlights the effect density has on the speed of our algorithm.

2. I chose 1000 repetitions because it would provide the most accurate average runtime and it would finish running
in my lifetime.

3. Changing the size of the board had little effect on the start and end densities -- all the 0.05 densities ran for about two ticks and all the 1 densities ran for **n** ticks. The greatest variation came around the 0.5-0.75 densities where the tick values fluctuated the most but even then, the pattern in how the values changed were similar between all board sizes.

4. As you increase the size of the board, the greatest number of ticks also went up but the density at which the greatest number of ticks was found did not change. I tested this by running trials on all three board sizes, 100, 500, and 1000, for 100 runs each. These were the results:
| Size | 100    | Size | 500     | Size | 1000    |
|-----:|--------|-----:|---------|-----:|---------|
| 0.05 |  1.36  | 0.05 |   1.98  | 0.05 |   2.34  |
| 0.10 |  1.93  | 0.10 |   3.05  | 0.10 |   3.51  |
| 0.15 |  2.78  | 0.15 |   4.21  | 0.15 |   4.84  |
| 0.20 |   3.8  | 0.20 |   5.64  | 0.20 |   6.36  |
| 0.25 |  5.07  | 0.25 |   7.05  | 0.25 |   8.58  |
| 0.30 |  6.83  | 0.30 |   9.41  | 0.30 |  11.14  |
| 0.35 |   8.6  | 0.35 |  13.19  | 0.35 |  15.23  |
| 0.40 |  13.15 | 0.40 |  19.46  | 0.40 |  21.88  |
| 0.45 |  17.05 | 0.45 |  27.83  | 0.45 |  33.16  |
| 0.50 |  33.44 | 0.50 |  48.64  | 0.50 |   59.8  |
| 0.55 |  67.41 | 0.55 |  127.85 | 0.55 |  158.03 |
| 0.60 | 196.13 | 0.60 | 1206.28 | 0.60 | 2518.97 |
| 0.65 | 174.93 | 0.65 |  772.89 | 0.65 | 1493.41 |
| 0.70 | 145.93 | 0.70 |  670.46 | 0.70 | 1318.56 |
| 0.75 | 131.66 | 0.75 |  619.42 | 0.75 | 1223.93 |
| 0.80 | 122.52 | 0.80 |  584.8  | 0.80 | 1158.65 |
| 0.85 | 115.68 | 0.85 |  559.18 | 0.85 | 1109.45 |
| 0.90 | 110.63 | 0.90 |  537.88 | 0.90 | 1069.27 |
| 0.95 |  106.3 | 0.95 |  520.12 | 0.95 | 1035.45 |
| 1.00 |   100  | 1.00 |   500   | 1.00 |   1000  |

5. A density of 60% yields the greatest burn time.
| Density |  Runtime |
|:-------:|:--------:|
|   0.05  |   2.255  |
|   0.10  |   3.467  |
|   0.15  |   4.831  |
|   0.20  |   6.46   |
|   0.25  |   8.522  |
|   0.30  |   11.37  |
|   0.35  |  15.432  |
|   0.40  |  21.803  |
|   0.45  |  33.513  |
|   0.50  |  60.428  |
|   0.55  |  155.932 |
|   0.60  |  2545.73 |
|   0.65  |  1494.6  |
|   0.70  |  1318.59 |
|   0.75  | 1223.535 |
|   0.80  | 1158.818 |
|   0.85  | 1109.546 |
|   0.90  | 1069.562 |
|   0.95  | 1035.537 |
|   1.00  |   1000   |

  | Density |  Runtime |
|:-------:|:--------:|
|   0.55  |  155.098 |
|   0.56  |  212.191 |
|   0.57  |  325.381 |
|   0.58  |  593.295 |
|   0.59  | 1677.424 |
|   0.60  | 2537.785 |
|   0.61  | 1994.032 |
|   0.62  |  1762.47 |
|   0.63  |  1641.6  |
|   0.64  | 1555.627 |
|   0.65  | 1495.334 |
