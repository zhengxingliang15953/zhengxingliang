export let pressData = [
    "清华大学出版社",
    "北京大学出版社",
    "浙江人民大学出版社",
    "电子工业出版社",
    "高等教育出版社",
    "南京师范大学出版社",
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