package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xefd$MediaData extends MessageMicro<oidb_0xefd$MediaData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 72, 82}, new String[]{"text", "pic_url", "pic_width", "pic_length", "sound_url", "sound_duration", "video_url", "video_duration", "media_type", "thumbnail_url"}, new Object[]{"", "", 0, 0, "", 0, "", 0, 0, ""}, oidb_0xefd$MediaData.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public final PBUInt32Field pic_width = PBField.initUInt32(0);
    public final PBUInt32Field pic_length = PBField.initUInt32(0);
    public final PBStringField sound_url = PBField.initString("");
    public final PBUInt32Field sound_duration = PBField.initUInt32(0);
    public final PBStringField video_url = PBField.initString("");
    public final PBUInt32Field video_duration = PBField.initUInt32(0);
    public final PBUInt32Field media_type = PBField.initUInt32(0);
    public final PBStringField thumbnail_url = PBField.initString("");
}
