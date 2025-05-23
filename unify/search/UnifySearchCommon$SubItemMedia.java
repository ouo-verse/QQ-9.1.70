package unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchCommon$SubItemMedia extends MessageMicro<UnifySearchCommon$SubItemMedia> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField coverUrl;
    public final PBBytesField description;
    public final PBUInt32Field type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "coverUrl", "description"}, new Object[]{0, byteStringMicro, byteStringMicro}, UnifySearchCommon$SubItemMedia.class);
    }

    public UnifySearchCommon$SubItemMedia() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.coverUrl = PBField.initBytes(byteStringMicro);
        this.description = PBField.initBytes(byteStringMicro);
    }
}
