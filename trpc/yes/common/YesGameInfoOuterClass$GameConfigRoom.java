package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigRoom extends MessageMicro<YesGameInfoOuterClass$GameConfigRoom> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"game_info", "label1", "label2", "label3", "chat_info", "hall_config", "mic_card_config", "hall_input_config"}, new Object[]{null, null, null, null, null, null, null, null}, YesGameInfoOuterClass$GameConfigRoom.class);
    public YesGameInfoOuterClass$GameConfigLabel game_info = new YesGameInfoOuterClass$GameConfigLabel();
    public YesGameInfoOuterClass$GameConfigLabel label1 = new YesGameInfoOuterClass$GameConfigLabel();
    public YesGameInfoOuterClass$GameConfigLabel label2 = new YesGameInfoOuterClass$GameConfigLabel();
    public YesGameInfoOuterClass$GameConfigLabel label3 = new YesGameInfoOuterClass$GameConfigLabel();
    public YesGameInfoOuterClass$GameConfigRoomChat chat_info = new YesGameInfoOuterClass$GameConfigRoomChat();
    public YesGameInfoOuterClass$GameConfigOfHall hall_config = new YesGameInfoOuterClass$GameConfigOfHall();
    public YesGameInfoOuterClass$GameConfigOfMicCard mic_card_config = new YesGameInfoOuterClass$GameConfigOfMicCard();
    public YesGameInfoOuterClass$GameConfigOfHallInput hall_input_config = new YesGameInfoOuterClass$GameConfigOfHallInput();
}
