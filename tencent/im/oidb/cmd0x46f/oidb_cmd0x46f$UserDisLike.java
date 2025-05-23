package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x46f$UserDisLike extends MessageMicro<oidb_cmd0x46f$UserDisLike> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_dislike_account_id;
    public final PBBytesField bytes_dislike_tag_name;
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt64Field uint64_dislike_tagid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"type", "uint64_dislike_tagid", "bytes_dislike_account_id", "bytes_dislike_tag_name"}, new Object[]{1, 0L, byteStringMicro, byteStringMicro}, oidb_cmd0x46f$UserDisLike.class);
    }

    public oidb_cmd0x46f$UserDisLike() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_dislike_account_id = PBField.initBytes(byteStringMicro);
        this.bytes_dislike_tag_name = PBField.initBytes(byteStringMicro);
    }
}
