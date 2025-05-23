package tencent.im.msg;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$Attr extends MessageMicro<im_msg_body$Attr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74, 82}, new String[]{"code_page", "time", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "color", "size", QQWinkConstants.TAB_EFFECT, "char_set", "pitch_and_family", "font_name", "reserve_data"}, new Object[]{-1, 1, 0, 0, 10, 7, 78, 90, "Times New Roman", ByteStringMicro.EMPTY}, im_msg_body$Attr.class);
    public final PBSInt32Field code_page = PBField.initSInt32(-1);
    public final PBUInt32Field time = PBField.initUInt32(1);
    public final PBUInt32Field random = PBField.initUInt32(0);
    public final PBUInt32Field color = PBField.initUInt32(0);
    public final PBUInt32Field size = PBField.initUInt32(10);
    public final PBUInt32Field effect = PBField.initUInt32(7);
    public final PBUInt32Field char_set = PBField.initUInt32(78);
    public final PBUInt32Field pitch_and_family = PBField.initUInt32(90);
    public final PBStringField font_name = PBField.initString("Times New Roman");
    public final PBBytesField reserve_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
