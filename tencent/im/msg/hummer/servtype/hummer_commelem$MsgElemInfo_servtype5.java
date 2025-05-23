package tencent.im.msg.hummer.servtype;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype5 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype5> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field author;
    public final PBBytesField comment_content;
    public final PBBytesField cover;
    public final PBUInt64Field createTime;
    public final PBBytesField summary;
    public final PBBytesField title;
    public final PBBytesField vid;

    static {
        String[] strArr = {"vid", "cover", "title", "summary", WadlProxyConsts.CREATE_TIME, "comment_content", "author"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0L}, hummer_commelem$MsgElemInfo_servtype5.class);
    }

    public hummer_commelem$MsgElemInfo_servtype5() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.vid = PBField.initBytes(byteStringMicro);
        this.cover = PBField.initBytes(byteStringMicro);
        this.title = PBField.initBytes(byteStringMicro);
        this.summary = PBField.initBytes(byteStringMicro);
        this.createTime = PBField.initUInt64(0L);
        this.comment_content = PBField.initBytes(byteStringMicro);
        this.author = PBField.initUInt64(0L);
    }
}
