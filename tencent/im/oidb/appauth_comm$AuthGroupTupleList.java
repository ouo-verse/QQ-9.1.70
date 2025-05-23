package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appauth_comm$AuthGroupTupleList extends MessageMicro<appauth_comm$AuthGroupTupleList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tuple_list"}, new Object[]{null}, appauth_comm$AuthGroupTupleList.class);
    public final PBRepeatMessageField<appauth_comm$AuthGroupTuple> tuple_list = PBField.initRepeatMessage(appauth_comm$AuthGroupTuple.class);
}
