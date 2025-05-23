package ufo;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.data.SquareJSConst;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$SetUgcRightReq extends MessageMicro<UgcRight$SetUgcRightReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{AppConstants.Key.KEY_QZONE_UGCKEY, "rightInfo"}, new Object[]{null, null}, UgcRight$SetUgcRightReq.class);
    public UgcRight$UgcDataKey ugcKey = new UgcRight$UgcDataKey();
    public UgcRight$RightInfo rightInfo = new MessageMicro<UgcRight$RightInfo>() { // from class: ufo.UgcRight$RightInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"rightFlag", "tagList", SquareJSConst.Params.PARAMS_UIN_LIST}, new Object[]{0L, null, ""}, UgcRight$RightInfo.class);
        public final PBUInt64Field rightFlag = PBField.initUInt64(0);
        public final PBRepeatMessageField<UgcRight$TagInfo> tagList = PBField.initRepeatMessage(UgcRight$TagInfo.class);
        public final PBRepeatField<String> uinList = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
