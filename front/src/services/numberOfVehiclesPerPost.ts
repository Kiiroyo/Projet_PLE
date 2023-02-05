const data = [
    { date: "03/10/22", number: 6077, post: "P17" },
    { date: "03/10/22", number: 2195, post: "P4" },
    { date: "03/10/22", number: 1836, post: "P5" },
    { date: "03/10/22", number: 1787, post: "P9" },
    { date: "04/10/22", number: 1497, post: "P12" },
    { date: "04/10/22", number: 13508, post: "P17" },
    { date: "04/10/22", number: 1503, post: "P19" },
    { date: "04/10/22", number: 2679, post: "P23" },
    { date: "04/10/22", number: 2704, post: "P24" },
    { date: "04/10/22", number: 4371, post: "P26" },
    { date: "04/10/22", number: 7277, post: "P4" },
    { date: "04/10/22", number: 4348, post: "P5" },
    { date: "04/10/22", number: 4855, post: "P9" },
    { date: "05/10/22", number: 2318, post: "P12" },
    { date: "05/10/22", number: 14307, post: "P17" },
    { date: "05/10/22", number: 2049, post: "P19" },
    { date: "05/10/22", number: 3416, post: "P23" },
    { date: "05/10/22", number: 3231, post: "P24" },
    { date: "05/10/22", number: 6099, post: "P26" },
    { date: "05/10/22", number: 7710, post: "P4" },
    { date: "05/10/22", number: 4018, post: "P5" },
    { date: "05/10/22", number: 4526, post: "P9" },
    { date: "06/10/22", number: 2267, post: "P12" },
    { date: "06/10/22", number: 14603, post: "P17" },
    { date: "06/10/22", number: 2244, post: "P19" },
    { date: "06/10/22", number: 417, post: "P20" },
    { date: "06/10/22", number: 3343, post: "P23" },
    { date: "06/10/22", number: 3541, post: "P24" },
    { date: "06/10/22", number: 6365, post: "P26" },
    { date: "06/10/22", number: 7533, post: "P4" },
    { date: "06/10/22", number: 4307, post: "P5" },
    { date: "06/10/22", number: 4552, post: "P9" },
    { date: "07/10/22", number: 6705, post: "P1" },
    { date: "07/10/22", number: 2172, post: "P12" },
    { date: "07/10/22", number: 2167, post: "P13" },
    { date: "07/10/22", number: 14172, post: "P17" },
    { date: "07/10/22", number: 2078, post: "P19" },
    { date: "07/10/22", number: 920, post: "P20" },
    { date: "07/10/22", number: 3102, post: "P23" },
    { date: "07/10/22", number: 3420, post: "P24" },
    { date: "07/10/22", number: 6341, post: "P26" },
    { date: "07/10/22", number: 7864, post: "P4" },
    { date: "07/10/22", number: 4351, post: "P5" },
    { date: "07/10/22", number: 4692, post: "P9" },
    { date: "08/10/22", number: 4471, post: "P1" },
    { date: "08/10/22", number: 111, post: "P12" },
    { date: "08/10/22", number: 1541, post: "P13" },
    { date: "08/10/22", number: 9656, post: "P17" },
    { date: "08/10/22", number: 699, post: "P19" },
    { date: "08/10/22", number: 304, post: "P20" },
    { date: "08/10/22", number: 1853, post: "P23" },
    { date: "08/10/22", number: 1476, post: "P24" },
    { date: "08/10/22", number: 2696, post: "P26" },
    { date: "08/10/22", number: 4931, post: "P4" },
    { date: "08/10/22", number: 2039, post: "P5" },
    { date: "08/10/22", number: 2348, post: "P9" },
    { date: "09/10/22", number: 4896, post: "P1" },
    { date: "09/10/22", number: 1318, post: "P13" },
    { date: "09/10/22", number: 8868, post: "P17" },
    { date: "09/10/22", number: 933, post: "P19" },
    { date: "09/10/22", number: 523, post: "P20" },
    { date: "09/10/22", number: 1522, post: "P23" },
    { date: "09/10/22", number: 1487, post: "P24" },
    { date: "09/10/22", number: 2455, post: "P26" },
    { date: "09/10/22", number: 4508, post: "P4" },
    { date: "09/10/22", number: 1833, post: "P5" },
    { date: "09/10/22", number: 1928, post: "P9" },
    { date: "10/10/22", number: 9058, post: "P1" },
    { date: "10/10/22", number: 483, post: "P10" },
    { date: "10/10/22", number: 3360, post: "P13" },
    { date: "10/10/22", number: 13428, post: "P17" },
    { date: "10/10/22", number: 2191, post: "P19" },
    { date: "10/10/22", number: 859, post: "P20" },
    { date: "10/10/22", number: 4513, post: "P23" },
    { date: "10/10/22", number: 586, post: "P24" },
    { date: "10/10/22", number: 7077, post: "P26" },
    { date: "10/10/22", number: 4141, post: "P3" },
    { date: "10/10/22", number: 7346, post: "P4" },
    { date: "10/10/22", number: 4240, post: "P5" },
    { date: "10/10/22", number: 4259, post: "P9" },
    { date: "11/10/22", number: 9038, post: "P1" },
    { date: "11/10/22", number: 745, post: "P10" },
    { date: "11/10/22", number: 3547, post: "P13" },
    { date: "11/10/22", number: 12734, post: "P17" },
    { date: "11/10/22", number: 2392, post: "P19" },
    { date: "11/10/22", number: 967, post: "P20" },
    { date: "11/10/22", number: 4866, post: "P23" },
    { date: "11/10/22", number: 54, post: "P24" },
    { date: "11/10/22", number: 8034, post: "P26" },
    { date: "11/10/22", number: 6169, post: "P3" },
    { date: "11/10/22", number: 7449, post: "P4" },
    { date: "11/10/22", number: 4483, post: "P5" },
    { date: "11/10/22", number: 4688, post: "P9" },
    { date: "12/10/22", number: 9208, post: "P1" },
    { date: "12/10/22", number: 623, post: "P10" },
    { date: "12/10/22", number: 1133, post: "P12" },
    { date: "12/10/22", number: 3194, post: "P13" },
    { date: "12/10/22", number: 14187, post: "P17" },
    { date: "12/10/22", number: 2074, post: "P19" },
    { date: "12/10/22", number: 888, post: "P20" },
    { date: "12/10/22", number: 4466, post: "P23" },
    { date: "12/10/22", number: 64, post: "P24" },
    { date: "12/10/22", number: 7391, post: "P26" },
    { date: "12/10/22", number: 6252, post: "P3" },
    { date: "12/10/22", number: 8054, post: "P4" },
    { date: "12/10/22", number: 4040, post: "P5" },
    { date: "12/10/22", number: 4318, post: "P9" },
    { date: "13/10/22", number: 8925, post: "P1" },
    { date: "13/10/22", number: 662, post: "P10" },
    { date: "13/10/22", number: 2198, post: "P12" },
    { date: "13/10/22", number: 3288, post: "P13" },
    { date: "13/10/22", number: 14261, post: "P17" },
    { date: "13/10/22", number: 2261, post: "P19" },
    { date: "13/10/22", number: 964, post: "P20" },
    { date: "13/10/22", number: 3692, post: "P23" },
    { date: "13/10/22", number: 1422, post: "P24" },
    { date: "13/10/22", number: 7199, post: "P26" },
    { date: "13/10/22", number: 6230, post: "P3" },
    { date: "13/10/22", number: 7845, post: "P4" },
    { date: "13/10/22", number: 4226, post: "P5" },
    { date: "13/10/22", number: 4351, post: "P9" },
    { date: "14/10/22", number: 9228, post: "P1" },
    { date: "14/10/22", number: 583, post: "P10" },
    { date: "14/10/22", number: 2007, post: "P12" },
    { date: "14/10/22", number: 3097, post: "P13" },
    { date: "14/10/22", number: 14095, post: "P17" },
    { date: "14/10/22", number: 2066, post: "P19" },
    { date: "14/10/22", number: 868, post: "P20" },
    { date: "14/10/22", number: 3164, post: "P23" },
    { date: "14/10/22", number: 3017, post: "P24" },
    { date: "14/10/22", number: 6193, post: "P26" },
    { date: "14/10/22", number: 6220, post: "P3" },
    { date: "14/10/22", number: 8053, post: "P4" },
    { date: "14/10/22", number: 4122, post: "P5" },
    { date: "14/10/22", number: 4318, post: "P9" },
    { date: "15/10/22", number: 4719, post: "P1" },
    { date: "15/10/22", number: 26, post: "P10" },
    { date: "15/10/22", number: 330, post: "P12" },
    { date: "15/10/22", number: 383, post: "P13" },
    { date: "15/10/22", number: 9907, post: "P17" },
    { date: "15/10/22", number: 553, post: "P19" },
    { date: "15/10/22", number: 256, post: "P20" },
    { date: "15/10/22", number: 2032, post: "P23" },
    { date: "15/10/22", number: 1499, post: "P24" },
    { date: "15/10/22", number: 2835, post: "P26" },
    { date: "15/10/22", number: 5412, post: "P3" },
    { date: "15/10/22", number: 4962, post: "P4" },
    { date: "15/10/22", number: 2124, post: "P5" },
    { date: "15/10/22", number: 2315, post: "P9" },
    { date: "16/10/22", number: 4088, post: "P1" },
    { date: "16/10/22", number: 37, post: "P10" },
    { date: "16/10/22", number: 12, post: "P12" },
    { date: "16/10/22", number: 391, post: "P13" },
    { date: "16/10/22", number: 8817, post: "P17" },
    { date: "16/10/22", number: 411, post: "P19" },
    { date: "16/10/22", number: 152, post: "P20" },
    { date: "16/10/22", number: 1515, post: "P23" },
    { date: "16/10/22", number: 1249, post: "P24" },
    { date: "16/10/22", number: 2124, post: "P26" },
    { date: "16/10/22", number: 4863, post: "P3" },
    { date: "16/10/22", number: 3908, post: "P4" },
    { date: "16/10/22", number: 1531, post: "P5" },
    { date: "16/10/22", number: 1912, post: "P9" },
    { date: "17/10/22", number: 8826, post: "P1" },
    { date: "17/10/22", number: 751, post: "P10" },
    { date: "17/10/22", number: 826, post: "P12" },
    { date: "17/10/22", number: 2976, post: "P13" },
    { date: "17/10/22", number: 13331, post: "P17" },
    { date: "17/10/22", number: 2388, post: "P19" },
    { date: "17/10/22", number: 917, post: "P20" },
    { date: "17/10/22", number: 3089, post: "P23" },
    { date: "17/10/22", number: 3256, post: "P24" },
    { date: "17/10/22", number: 5713, post: "P26" },
    { date: "17/10/22", number: 5762, post: "P3" },
    { date: "17/10/22", number: 7344, post: "P4" },
    { date: "17/10/22", number: 4009, post: "P5" },
    { date: "17/10/22", number: 4304, post: "P9" },
    { date: "18/10/22", number: 9443, post: "P1" },
    { date: "18/10/22", number: 777, post: "P10" },
    { date: "18/10/22", number: 2434, post: "P12" },
    { date: "18/10/22", number: 3315, post: "P13" },
    { date: "18/10/22", number: 3615, post: "P17" },
    { date: "18/10/22", number: 2301, post: "P19" },
    { date: "18/10/22", number: 1030, post: "P20" },
    { date: "18/10/22", number: 3307, post: "P23" },
    { date: "18/10/22", number: 3424, post: "P24" },
    { date: "18/10/22", number: 6089, post: "P26" },
    { date: "18/10/22", number: 5889, post: "P3" },
    { date: "18/10/22", number: 2370, post: "P4" },
    { date: "18/10/22", number: 1323, post: "P5" },
    { date: "18/10/22", number: 1241, post: "P9" },
    { date: "19/10/22", number: 9040, post: "P1" },
    { date: "19/10/22", number: 884, post: "P10" },
    { date: "19/10/22", number: 2293, post: "P12" },
    { date: "19/10/22", number: 3098, post: "P13" },
    { date: "19/10/22", number: 703, post: "P19" },
    { date: "19/10/22", number: 986, post: "P20" },
    { date: "19/10/22", number: 563, post: "P23" },
    { date: "19/10/22", number: 754, post: "P24" },
    { date: "19/10/22", number: 1812, post: "P26" },
    { date: "19/10/22", number: 1564, post: "P3" },
    { date: "20/10/22", number: 4635, post: "P1" },
    { date: "20/10/22", number: 788, post: "P10" },
    { date: "20/10/22", number: 1029, post: "P12" },
    { date: "20/10/22", number: 1273, post: "P13" },
    { date: "20/10/22", number: 816, post: "P20" },
    { date: "21/10/22", number: 198, post: "P10" },
    { date: "21/10/22", number: 1, post: "P20" },
];

export const getAllDates = () => {
    let dates: string[] = [];
    data.forEach((item) => {
        if (!dates.includes(item.date)) {
            dates.push(item.date);
        }
    });
    return dates;
};

export const getPostsByDate = (date: string) => {
    const posts: { post: string; number: number }[] = [];
    data.forEach((item) => {
        if (item.date === date) {
            posts.push({
                post: item.post,
                number: item.number || 0,
            });
        }
    });
    return posts;
};
