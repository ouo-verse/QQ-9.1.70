package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class faceroam_sso$EmojiItem extends MessageMicro<faceroam_sso$EmojiItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 64, 72, 80, 88}, new String[]{"file_id", "md5", "download_url", "file_type", "flag", "pkg_id", "pic_id", "jump_id", "size", "width", "height"}, new Object[]{"", "", "", 0, 0, 0, "", 0, 0, 0, 0}, faceroam_sso$EmojiItem.class);
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public final PBUInt32Field file_type = PBField.initUInt32(0);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBUInt32Field pkg_id = PBField.initUInt32(0);
    public final PBStringField pic_id = PBField.initString("");
    public final PBUInt32Field jump_id = PBField.initUInt32(0);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
}
