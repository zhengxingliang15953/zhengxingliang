export let changeTime=function(value){
    value=value.toString();
    let list=[];
  let str="";
  list=value.split(' ');
  switch(list[1]){
    case 'Jan':str='01';break;
    case 'Feb':str='02';break;
    case 'Mar':str='03';break;
    case 'Apr':str='04';break;
    case 'May':str='05';break;
    case 'Jun':str='06';break;
    case 'Jul':str='07';break;
    case 'Aug':str='08';break;
    case 'Sept':str='09';break;
    case 'Oct':str='10';break;
    case 'Nov':str='11';break;
    case 'Dec':str='12';break;
  }
  return `${list[3]}-${str}-${list[2]}`;
}