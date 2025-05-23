package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tenpay.realname.RealNameSource;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype16 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype16> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ctr_version;
    public final PBBytesField doodleUrl;
    public final PBBytesField md5;
    public final PBBytesField sourceActionData;
    public final PBBytesField sourceActionType;
    public final PBBytesField sourceName;
    public final PBBytesField storyID;
    public final PBBytesField thumbUrl;
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBBytesField unionID;
    public final PBUInt32Field videoHeight;
    public final PBUInt32Field videoWidth;

    static {
        String[] strArr = {"uid", "unionID", "storyID", "md5", "thumbUrl", "doodleUrl", "videoWidth", "videoHeight", RealNameSource.EXTRA_KEY_SOURCE_NAME, "sourceActionType", "sourceActionData", "ctr_version"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 90, 96}, strArr, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0}, hummer_commelem$MsgElemInfo_servtype16.class);
    }

    public hummer_commelem$MsgElemInfo_servtype16() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.unionID = PBField.initBytes(byteStringMicro);
        this.storyID = PBField.initBytes(byteStringMicro);
        this.md5 = PBField.initBytes(byteStringMicro);
        this.thumbUrl = PBField.initBytes(byteStringMicro);
        this.doodleUrl = PBField.initBytes(byteStringMicro);
        this.videoWidth = PBField.initUInt32(0);
        this.videoHeight = PBField.initUInt32(0);
        this.sourceName = PBField.initBytes(byteStringMicro);
        this.sourceActionType = PBField.initBytes(byteStringMicro);
        this.sourceActionData = PBField.initBytes(byteStringMicro);
        this.ctr_version = PBField.initUInt32(0);
    }
}
