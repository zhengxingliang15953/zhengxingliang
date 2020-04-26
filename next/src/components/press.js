export let pressData = [
    "北京大学出版社",//b
    "电子工业出版社",//d
    "高等教育出版社",//g
    "国家图书馆出版社",
    "化学工业出版社",//h
    "机械工业出版社",//j
    "科学出版社",//k
    "南京师范大学出版社",//n
    "清华大学出版社",//q
    "人民出版社",//r
    "人民邮电出版社",
    "人民教育出版社",
    "中国水利水电出版社",//z
    "中国法律出版社",
    "中华书局",
    "浙江人民大学出版社",
    "浙江教育出版社",
];

export let timeChange = (value) => {
    let list = value.split(' ');
    let str = '';
    switch (list[1]) {
        case 'Jan': str = '01'; break;
        case 'Feb': str = '02'; break;
        case 'Mar': str = '03'; break;
        case 'Apr': str = '04'; break;
        case 'May': str = '05'; break;
        case 'Jun': str = '06'; break;
        case 'Jul': str = '07'; break;
        case 'Aug': str = '08'; break;
        case 'Sept': str = '09'; break;
        case 'Oct': str = '10'; break;
        case 'Nov': str = '11'; break;
        case 'Dec': str = '12'; break;
    }
    return `${list[3]}-${str}-${list[2]}`;
}