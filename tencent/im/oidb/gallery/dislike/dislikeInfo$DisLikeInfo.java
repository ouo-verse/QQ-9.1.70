package tencent.im.oidb.gallery.dislike;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class dislikeInfo$DisLikeInfo extends MessageMicro<dislikeInfo$DisLikeInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_dislike_account_id;
    public final PBBytesField bytes_dislike_describe;
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt64Field uint64_dislike_tagid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"type", "bytes_dislike_describe", "uint64_dislike_tagid", "bytes_dislike_account_id"}, new Object[]{1, byteStringMicro, 0L, byteStringMicro}, dislikeInfo$DisLikeInfo.class);
    }

    public dislikeInfo$DisLikeInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_dislike_describe = PBField.initBytes(byteStringMicro);
        this.uint64_dislike_tagid = PBField.initUInt64(0L);
        this.bytes_dislike_account_id = PBField.initBytes(byteStringMicro);
    }
}
