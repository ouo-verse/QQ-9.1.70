package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigRoomChat extends MessageMicro<YesGameInfoOuterClass$GameConfigRoomChat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"head_bg", "bg_hue", "recv_msg", "send_msg", "text_normal_hue", "text_weak_hue", "text_stress_hue"}, new Object[]{"", "", null, null, "", "", ""}, YesGameInfoOuterClass$GameConfigRoomChat.class);
    public final PBStringField head_bg = PBField.initString("");
    public final PBRepeatField<String> bg_hue = PBField.initRepeat(PBStringField.__repeatHelper__);
    public YesGameInfoOuterClass$GameConfigRoomChatMsg recv_msg = new YesGameInfoOuterClass$GameConfigRoomChatMsg();
    public YesGameInfoOuterClass$GameConfigRoomChatMsg send_msg = new YesGameInfoOuterClass$GameConfigRoomChatMsg();
    public final PBStringField text_normal_hue = PBField.initString("");
    public final PBStringField text_weak_hue = PBField.initString("");
    public final PBStringField text_stress_hue = PBField.initString("");
}
