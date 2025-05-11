var id = "";

function addTransporte(){
  location.href = "/add";
}

function updTransporte(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  if (typeof id != 'undefined'){
    location.href = "/upd/" + id;
  }
}

function delTransporte(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  alert(id);
  if (typeof id !== 'undefined'){
    location.href = "/del/" + id;
  }
}