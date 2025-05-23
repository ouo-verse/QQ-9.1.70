package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class s2cmsg$ChannelRecommendDaily extends MessageMicro<s2cmsg$ChannelRecommendDaily> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField avatar;
    public final PBBytesField jump_link;
    public final PBBytesField sub_title;
    public final PBBytesField title;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"title", "sub_title", "jump_link", "avatar"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, s2cmsg$ChannelRecommendDaily.class);
    }

    public s2cmsg$ChannelRecommendDaily() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.title = PBField.initBytes(byteStringMicro);
        this.sub_title = PBField.initBytes(byteStringMicro);
        this.jump_link = PBField.initBytes(byteStringMicro);
        this.avatar = PBField.initBytes(byteStringMicro);
    }
}
