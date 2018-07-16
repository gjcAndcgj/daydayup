---
layout: post
title: git的常规使用
category: 工具
tags: git
---

## 关联远程库   
### 1.创建SSH-Key   

用户主目录上有没有.ssh文件，没有则创建，一个是id_rsa和另一个id_rsa.pub对应的是私钥和公钥   

	$ ssh-keygen -t rsa -C "youremail@example.com"    
	
### 2.在github上操作    

创建ADD SSH Key,title写上名字和key中写上id_rsa.pub上的内容

## git的基本操作
### 1.git的安装（使用的配置）

	git config --global user.name "Your Name"  
	git config --global user.email "email@example.com"

### 2.git的初始化

	git init

### 3.git的添加
	git add file

### 4.git的提交
	git commit -m "xxxx"

### 5.查看仓库状态
	git status   
	git diff file  查看修改的内容  
	cat file 查看文件内容

### 6.版本的回退
	git log 显示最近的提交的日志  
	git log --pretty=oneline 显示简单的日志  
	git reflog 查看命令历史，回到未来  
	git reset --hard HEAD^ 回到上一个版本  
	git reset --hard 1321554  回到指定的版本
	git push -f  推送修改后的远程库的版本，强制性

### 7.撤销修改
	git checkout -- file  撤销修改文件一种是工作区修改未提交，一种是暂存区修改未提交  
	git checkout . && git clean -df   放弃所有修改，新增，删除文件
	git reset HEAD file 已经提交到暂存区 ，然后在checkout操作  
	git reset --hard 1635132 已经提交到版本库中 ，只能回归版本号
	

### 8.远程库
	git remote add origin git@server-name:path/repo-name.git  第一次提交需关联远程库的操作  
	git push -u origin master 第一次推送内容  
	git push origin master 推送最新的修改  
	git clone git@github.com:battleFrogs/xx.git  从远程库中拉取文件   


### 9.分支管理
	git branch 查看分支  
	git branch xx 创建分支  
	git checkout name 切换分支  
	git checkout -b name 创建并切换分支  
	git merge xx 合并到当前分支  
	git branch -d xx 删除分支  
	git stash 保存现场  
	git stash apply 恢复但不删除stash    
	git stash drop   删除stash  
	git stash pop 恢复现场  
	git branch -D name 强行删除分支  
	git branch --set-upstream dev origin/dev  指定本地dev分支与远程origin/dev分支的链接 
	git push origin local_branch:remote_branch   推送本地分支到远程分支
	git branch -r -D origin/BranchName  删除本地的远程分支
	git push origin -d BranchName  远程删除git服务器上的分支：

### 10.tag标签
	git tag v1.0  标记标签
	git tag  查看标签  
	git tag v0.9 1651465  给之前的commit打tag  
	git tag -a tagname -m "blablabla..." 指定标签信息  
	git push origin tagname 推送本地tag  
	git push origin --tags  推送全部未推送的tag   
	git tag -d tagname  删除本地标签  
	git push origin :refs/tags/v0.9 To git@github.com:michaelliao/learngit.git[deleted]         v0.9   删除远程tag   



## 多人合作
### 1.克隆远程库到本地修改提交
	git clone git@github.com:battleFrogs/xx.git  
	cd xx
	git checkout -b gh-pages origin/gh-pages  
	git add .  
	git commit -m "xxx"  
	git push origin gh-pages   
      
### 2.多人合作时修改提交   

	git push origin branch-name 尝试推送自己的修改    
	git pull  若推送失败则，则试图更新合并   
	再解决冲突，提交  
	git branch --set-upstream branch-name origin/branch-name 若本地分支和远程没有关联，则创建关联      


### 3.将远程git仓库里的指定分支拉取到本地（本地不存在的分支）   

	git checkout -b 本地分支名 origin/远程分支名   
	#若出现提示
	fatal: Cannot update paths and switch to branch 'dev2' at the same time.
	Did you intend to checkout 'origin/dev2' which can not be resolved as commit?
	#执行  
	git fetch 
	git checkout -b 本地分支名 origin/远程分支名   


###4.多人使用分支修改

	git checkout -b gjc  创建切换到gjc分支
	git add .   暂提交所有修改
	git commit -m "xxxx"  提交暂存区的所有修改   
	git checkout dev  切换到dev分支   
	git pull   先更新其他人的修改操作   
	git checkout gjc 切换到自己的分支  
	git merge dev  合并dev上的修改操作 ，有冲突则修改冲突   
    git checkout dev  切换到dev分支   
	git merge gjc  合并gjc分支上的修改    
	git push origin dev 


### 5.远程版本回归   
	
	// A1–A2–B1  A是你的提交，B是同事的提交，然后回退到A的版本
	git reflog  查看命令历史   
	git reset --hard Obfafd   回退版本  
	git push -f  强制推送到远程分支    
	
	#（1） 另一个同事 
	git reflog  查看命令历史   
	git checkout tony_branch        //先回到自己的分支  
	git reflog                      //接着看看当前的commit id,例如:0bbbbb    
	git reset --hard B1             //回到被覆盖的那次提交B1
	git checkout -b tony_backup     //拉个分支，用于保存之前因为回退版本被覆盖掉的提交B1
	git checkout tony_branch        //拉完分支，迅速回到自己分支
	git reset --hard 0bbbbbb        //马上回到自己分支的最前端   
	git reset --hard origin/master   Tony要把自己的本地master分支和远程master分支保持一致  
	//找回 自己B提交的内容
	git checkout master             //切换到master
	git merge tony_backup           //再合并一次带有B1的分支到master   

	# 另外同事没有提交被覆盖  
	git pull 
	git reset --hard origin/master  
	//他拉完代码git pull之后，只需要强制用远程master覆盖掉本地master  

	#（2）猪队友同事   
	//当他提示本地版本落后远程库 ，他直接push，直接回复  A1 – A2 – B1   
	git revert HEAD                     //撤销最近一次提交
	git revert HEAD~1                   //撤销上上次的提交，注意：数字从0开始
	git revert 0ffaacc                  //撤销0ffaacc这次提交    

	//revert 是撤销一次提交，所以后面的commit id是你需要回滚到的版本的前一次提交
	//使用revert HEAD是撤销最近的一次提交，如果你最近一次提交是用revert命令产生的，那么你再执行一次，就相当于撤销了上次的撤销操作，换句话说，你连续执行两次revert HEAD命令，就跟没执行是一样的
	//使用revert HEAD~1 表示撤销最近2次提交，这个数字是从0开始的，如果你之前撤销过产生了commi id，那么也会计算在内的。
	//如果使用 revert 撤销的不是最近一次提交，那么一定会有代码冲突，需要你合并代码，合并代码只需要把当前的代码全部去掉，保留之前版本的代码就可以了.
	  
	

### 6.推送本地分支local_branch到远程分支 remote_branch并建立关联关系   

	 a.远程已有remote_branch分支并且已经关联本地分支local_branch且本地已经切换到local_branch

          git push

     b.远程已有remote_branch分支但未关联本地分支local_branch且本地已经切换到local_branch

         git push -u origin/remote_branch

     c.远程没有有remote_branch分支并，本地已经切换到local_branch

        git push origin local_branch:remote_branch   
	
	
	
	






 