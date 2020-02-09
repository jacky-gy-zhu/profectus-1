package com.profectus.fishshop.command;

public class Government {

    private Command openCommand;
    private Command closeCommand;

    public Government(Command openCommand, Command closeCommand) {
        this.openCommand = openCommand;
        this.closeCommand = closeCommand;
    }

    public void open(){
        openCommand.execute();
    }

    public void close(){
        closeCommand.execute();
    }

}
