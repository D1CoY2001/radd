import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationLessThanZero() {
        Radio radio = new Radio();

        radio.setCurrentStation(-1);

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationMoreThanNine() {
        Radio radio = new Radio();

        radio.setCurrentStation(10);

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldMoveToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.next();

        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldMoveFromNinthStationToZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldMoveToPreviousStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldMoveFromZeroStationToNine() {
        Radio radio = new Radio();

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();

        radio.increaseVolume();

        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAboveMaximum() {
        Radio radio = new Radio();

        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();

        radio.increaseVolume();
        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowMinimum() {
        Radio radio = new Radio();

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldCreateRadioWithTenStationsByDefault() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldCreateRadioWithCustomStationCount() {
        Radio radio = new Radio(30);

        radio.setCurrentStation(29);

        assertEquals(29, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationEqualToStationCount() {
        Radio radio = new Radio(30);

        radio.setCurrentStation(30);

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldMoveFromLastCustomStationToZero() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldMoveFromZeroToLastCustomStation() {
        Radio radio = new Radio(30);

        radio.prev();

        assertEquals(29, radio.getCurrentStation());
    }
}