package tencent.im.oidb.cmd0x1004;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_cmd0x1004$Person extends MessageMicro<oidb_cmd0x1004$Person> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "nickname", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{0L, "", null}, oidb_cmd0x1004$Person.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nickname = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0x1004$Tag> tags = PBField.initRepeatMessage(oidb_cmd0x1004$Tag.class);
}
