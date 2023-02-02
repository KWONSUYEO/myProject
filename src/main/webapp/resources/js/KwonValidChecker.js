// 占쌉쇽옙占쏙옙 占쏙옙占� 占쏙옙占쌔야듸옙

// 占쌩몌옙占실몌옙 true(占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 true, 占쏙옙占쏙옙占쏙옙占싱몌옙 false)

// <input>占쏙옙 占쏙옙 占쏙옙
//		占싣뱄옙占싶듸옙 占싫억옙占쏙옙 true, 占쏙옙占쏙옙 占쏙옙占쏙옙 false
function isEmpty(input){
	return (!input.value);
}

// <input>占쏙옙 占쏙옙占쏙옙占쏙옙 占쌍억옙占쏙옙 占쏙옙
//		占싼깍옙, 특占쏙옙占쏙옙占쌘곤옙 占쏙옙占쌉되억옙 占쏙옙占쏙옙占쏙옙 true, 占쏙옙占쏙옙占쏙옙 false
function containsAnother(input){
	let pass = "1234567890qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM@_.";
	let iv = input.value;
	for(let i = 0; i<iv.length;i++){
		if(pass.indexOf(iv[i])==-1){ // pass占쏙옙 占쏙옙占쏙옙 占쌩울옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
			return true;
		}
	}
	return false;
}

function email(input){
	let e = "@"
	let iv = input.value;
	for(let i=0;i<iv.length;i++){
		if(pw.indexOf(iv[i])==-1){
			return true;
		}
	}
	return false;
		}



function onlyEng(input){
	let pw = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
	let iv = input.value;
	for(let i=0;i<iv.length;i++){
		if(pw.indexOf(iv[i])==-1){
			return true;
		}
	}
	return false;
}

// <input>, 占쏙옙占쌘쇽옙 占쌍억옙占쏙옙 占쏙옙
//		占쏙옙 占쏙옙占쌘쇽옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 true, 占싱삼옙占싱몌옙 false
function atLeastLetter(input,len){
	return (input.value.length < len);
}

// <input> X2 占쌍억옙占쏙옙 占쏙옙(pw,pw확占쏙옙)
//	占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쌕몌옙占쏙옙 true, 占쏙옙占쏙옙占쏙옙 false
function notEqualPw(input1, input2){
	return (input1.value != input2.value);
}

// <input>, 占쏙옙占쌘울옙 占쏙옙트 占쌍억옙占쏙옙 占쏙옙
//	占쏙옙占쏙옙占쏙옙 true, 占쏙옙占쏙옙占쏙옙 false (占쌉뤄옙占쏙옙 pw占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙 占쏙옙占�)
function notContain(input,passSet){
	let iv = input.value;
	for(let i = 0; i < passSet.length; i++){
		if(iv.indexOf(passSet[i]) != -1);
		return false;
	}
	return true;
}

// <input> 占쌍억옙占쏙옙 占쏙옙
//	占쏙옙占쏙옙 占싣닌곤옙 占쏙옙占쏙옙占쏙옙 true, 占쏙옙占쌘몌옙 占쏙옙占쏙옙占쏙옙 false
function isNotNumber(input){
	return isNaN(input.value);
}

// <input>占쏙옙 확占쏙옙占쏙옙 占쌍억옙占쏙옙 占쏙옙
//	확占쏙옙占쏙옙 占쏙옙占쏙옙 占싣니몌옙 true, 확占쏙옙占쏙옙 占쏙옙占싱몌옙 false
function isNotType(input,type){
	// .jpg, .gif,...
	type = "." + type;
	return(input.value.indexOf(type)==-1);
}










