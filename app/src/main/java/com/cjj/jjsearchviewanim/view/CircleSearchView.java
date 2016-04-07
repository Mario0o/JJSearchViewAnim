package com.cjj.jjsearchviewanim.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cjj.jjsearchviewanim.R;
import com.cjj.sva.JJSearchView;
import com.cjj.sva.anim.JJBaseController;
import com.cjj.sva.anim.controller.JJCircleToLineAlphaController;

/**
 * Created by sky on 16/4/7.
 */
public class CircleSearchView extends RelativeLayout {
    private Context mContext;
    private JJSearchView mSearchView;
    private EditText mEditText;

    public CircleSearchView(Context context) {
        this(context, null);
    }

    public CircleSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context context) {
        this.mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.view_circle_search, this);
        mSearchView = (JJSearchView) findViewById(R.id.search_view);
        mSearchView.setController(new JJCircleToLineAlphaController());
        mEditText = (EditText) findViewById(R.id.edit_text);

        mSearchView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSearchView.getState() == JJBaseController.STATE_ANIM_NONE) {
                    mSearchView.startAnim();
                    mEditText.setVisibility(View.VISIBLE);
                    mEditText.bringToFront();
                } else if (mSearchView.getState() == JJBaseController.STATE_ANIM_START) {
                    Toast.makeText(mContext, "正在搜索", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
