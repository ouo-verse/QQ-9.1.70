package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.data.SquareJSConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameMemberSelectInfo$QueryOldFriendsRsp extends MessageMicro<QQGameMemberSelectInfo$QueryOldFriendsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{SquareJSConst.Params.PARAMS_UIN_LIST}, new Object[]{0L}, QQGameMemberSelectInfo$QueryOldFriendsRsp.class);
    public final PBRepeatField<Long> uinList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
