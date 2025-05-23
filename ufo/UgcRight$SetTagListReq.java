package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.state.data.SquareJSConst;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$SetTagListReq extends MessageMicro<UgcRight$SetTagListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"uin", "cmd", "taginfo"}, new Object[]{"", 0, null}, UgcRight$SetTagListReq.class);
    public final PBStringField uin = PBField.initString("");
    public final PBInt32Field cmd = PBField.initInt32(0);
    public UgcRight$TagInfo taginfo = new MessageMicro<UgcRight$TagInfo>() { // from class: ufo.UgcRight$TagInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"tagID", "tagName", SquareJSConst.Params.PARAMS_UIN_LIST, "updateTime"}, new Object[]{"", "", "", 0}, UgcRight$TagInfo.class);
        public final PBStringField tagID = PBField.initString("");
        public final PBStringField tagName = PBField.initString("");
        public final PBRepeatField<String> uinList = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field updateTime = PBField.initUInt32(0);
    };
}
