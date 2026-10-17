#order of arguments in the method name positional->default->keyword->arbituary
#positional equal normal
#default means at function def putting =
#keyword means takes parameters in any order by place equal before argument while calling
#arbitary means allow multiple arguments like below like now i can add house no into shiiping still the code will work
#*args(positonal) converts  to tupel and **kwargs(kw=keyword) converts to dictionary (args and kwargs are not predefined we can chancge the name)
def shipping(*args,**kwargs):#both args and kwargs are allowed at same time

    for arg in args:
        print(arg,end="-")
    print()
    for value in kwargs.values():
        print(value)
    print(f"{kwargs.get('viilage')}")
    #below if statements are for the better understanding of the topics
    if "viilage" in kwargs:
        print(f"palleturodu from {kwargs.get('viilage')}")
    else:
        print(f"patnamodu from {kwargs.get('patnam')}")    
    
shipping("mr","hem","charan",
         #viilage="kkd",
         patnam="bangcock",
         city="tpt",
         state="ap",
         code=517520)    
        