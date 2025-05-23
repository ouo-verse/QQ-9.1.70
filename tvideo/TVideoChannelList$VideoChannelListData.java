package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoChannelList$VideoChannelListData extends MessageMicro<TVideoChannelList$VideoChannelListData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"channel_list"}, new Object[]{null}, TVideoChannelList$VideoChannelListData.class);
    public final PBRepeatMessageField<TVideoChannelList$VideoChannelData> channel_list = PBField.initRepeatMessage(TVideoChannelList$VideoChannelData.class);
}
