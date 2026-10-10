// Radio supports a configurable number of stations.
    private int currentStation;
    private int stationCount;
    private int currentVolume;

    public Radio() {
        this(10);
    }

    public Radio(int stationCount) {
        this.stationCount = stationCount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation < stationCount) {
            this.currentStation = currentStation;
        }
    }

    public void next() {
        if (currentStation == stationCount - 1) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationCount - 1;
        } else {
            currentStation = currentStation - 1;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}
