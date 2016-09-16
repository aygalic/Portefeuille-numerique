				<div id="header-top-avlar">
					
					<div class="width-container-pro">
						<?php if ( is_active_sidebar( 'header-top-left-progression' ) ) { ?>
						<div class="header-top-left-avlar">
							<?php dynamic_sidebar( 'header-top-left-progression' ); ?>
						</div>
						<?php } ?>
						
						<div class="header-top-right-avlar">			
							<?php wp_nav_menu( array('theme_location' => 'profile', 'menu_class' => 'sf-menu', 'container' => '', 'fallback_cb' => false, 'walker'  => new ProgressionFrontendWalker ) ); ?>
						</div>
						<div class="clearfix-pro"></div>
					</div>
					
				</div><!-- close #header-top-avlar -->